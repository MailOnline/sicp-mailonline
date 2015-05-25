;; Exercise 2.76
;; As a large system with generic operations evolves, new types of data objects
;; or new operations may be needed.  For each of the three strategies - generic
;; operations with explicit dispatch, data-directed style, and message-passing
;; style - describe the changes that must be made to a system in order to add
;; new types or new operations.  Which organization would be most appropriate
;; for a system in which new types must often be added?  Which would be most
;; appropriate for a system in which new operations must often be added?

;; * explicit dispatch
;; ** new type
;;    - define a tag for the new type
;;    - implement constructor and return tagged type
;;    - implement a selector to identify the type
;;    - provide type-specific implementations of all operations
;;    - amend all generic operations with a new type check, calling the
;;      type-specific implementation as appropriate
;; ** new operation
;;    - provide type-specific implementations for each type
;;    - provide generic operation that dispatches on type

;; * data-directed style
;; ** new type
;;    - define a tag for the new type
;;    - implement constructor and return tagged type
;;    - provide type-specific implementations of all operations
;;    - register type-specific implementations with generic dispatch table
;; ** new operation
;;    - provide type-specific implementations for each type
;;    - register type-specific implementations with generic dispatch table

;; * message-passing style
;; ** new type
;;    - implement type providing all operations

;; ** new operation
;;    - add implementation to each type


;; message-passing style is most appropriate when new types must often be added.
;; The change is limited to the implementation of the new type itself.

;; data-directed style is most appropriate when new operations must often be
;; added.
;; The generic dispatch table allows new operations to be added to types without
;; building a large unwieldy conditional expression.
