;; Exercise 2.74
;; Insatiable Enterprises, Inc., is a highly decentralized conglomerate company
;; consisting of a large number of independent divisions located all over the
;; world.  The company's computer facilities have just been interconnected by
;; means of a clever network-interfacing scheme that makes the entire network
;; appear to any user to be a single computer.  Insatiable's president, in her
;; first attempt to exploit the ability of the network to extract administrative
;; information from division files, is dismayed to discover that, although all
;; the division files have been implemented as data structures in Scheme, the
;; particular data structure used varies from division to division.  A meeting
;; of division managers is hastily called to search for a strategy to integrate
;; the files that will satisfy headquarter's needs while preserving the existing
;; autonomy of divisions.
;; Show how such a strategy can be implemented with data-directed programming.
;; As an example, suppose that each division's personnel records consist of a
;; single file, which contains a set of records keyed on employee's names.  The
;; structure of the set varies from division to division.  Furthermore, each
;; employee's record is itself a set (structured differently from division to
;; division) that contains information keyed under identifiers such as address
;; and salary.  In particular:
;;
;; a.  Implement for heaquarters a get-record procedure that retrieves a
;; specified employee's record from a specified personnel file.  The procedure
;; should be applicable to any division's file.  Explain how the individual
;; division's files should be structured.  In particular, what type information
;; must be supplied?
;; b.  Implement for headquarters a get-salary procedure that returns the salary
;; information from a given employee's record from any divison's personnel
;; file.  How should the record be structured in order to make this operation
;; work?
;; c.  Implement for headquarters a find-employee-record procedure.  This should
;; search all the divisions' files for the record of a given employee and return
;; the record.  Assume that this procedure takes as arguments an employee's name
;; and a list of all the divison's files.
;; d.  When Insatiable takes over a new company, what changes must be made in
;; order to incorporate the new personnel information into the central system?

(ns sicp-mailonline.exercises.2-74)

(declare get)

;; tagged file abstraction
(defn make-personnel-file [division file]
  (list division file))

(defn- get-personnel-file-division [personnel-file]
  (first personnel-file))

(defn- get-personnel-file-file [personnel-file]
  (second personnel-file))

;; tagged record abstraction
(defn- make-record [division employee]
  (list division employee))

(defn get-division [record]
  (first record))

(defn get-employee [record]
  (second record))

;; core abstractions for headquarters
(defn get-record [name personnel-file]
  (let [division (get-personnel-file-division personnel-file)]    
    (if-let [get-division-employee (get :get-division-employee division)]
      (when-let [employee (get-division-employee name (get-personnel-file-file personnel-file))]
        (make-record division employee))
      (throw (IllegalArgumentException. (str "Unknown division: " division))))))

(defn get-salary [record]
  (let [division (get-division record)]
    (if-let [get-employee-salary (get :get-employee-salary division)]
      (get-employee-salary (get-employee record))
      (throw (IllegalArgumentException. (str "Unknown division: " division))))))

(defn find-employee-record [name personnel-files]
  (letfn [(iter [search-files]
            (if (empty? search-files)
              nil
              (if-let [record (get-record name (first search-files))]
                record
                (recur (rest search-files)))))]
    (iter personnel-files)))

;; engineering division implementation
(defn- get-division-employee-engineering [name file]
  (let [key (str "engineer-" name)]
    (clojure.core/get file key)))

(defn- get-employee-salary-engineering [employee]
  (:engineering-salary employee))

;; sales division implementation
(defn- get-division-employee-sales [name file]
  (let [key (str "salesperson-" name)]
    (clojure.core/get file key)))

(defn- get-employee-salary-sales [employee]
  (:sales-salary employee))

;; data-directed configuration
(def ^:private op-table (atom {}))

(defn- put [op type item]
  (swap! op-table assoc-in [op type] item))

(defn- get [op type]
  (get-in @op-table [op type]))

(defn install-personnel! []
  (put :get-division-employee :engineering get-division-employee-engineering)
  (put :get-division-employee :sales get-division-employee-sales)
  (put :get-employee-salary :engineering get-employee-salary-engineering)
  (put :get-employee-salary :sales get-employee-salary-sales))


;; a.  A personnel file must provide the division to which it relates.  This
;; implementation provides a personnel-file abstraction that tags the underlying
;; file representation with the division.  This frees the individual division's
;; file to be structured in any way.  It must simply be 'wrapped' as a personnel
;; file before it is used by the procedure.
;; b.  Again, the key type information required is the employee's division.
;; This implementation provides a tagged record abstraction.  As get-record
;; can determine the division to which the personnel file relates, it simply
;; tags the returned record with that division.  This frees a division to
;; structure an employee's record in any way.
;; d.  Any new division simply needs to provide implementations of
;; get-division-employee and get-employee-salary, and register those
;; implementations in install-personnel!  The core procedures do not need to
;; change in any way.
