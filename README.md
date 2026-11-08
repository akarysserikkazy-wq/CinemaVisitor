## Assignment #6 — Visitor pattern
### Student: Serikkazy Akarys
### Group: SE-2514

# Cinema Ticket Visitor - Visitor Pattern (Java)

## Idea
A cinema order contains tickets of different types (standard, VIP, child).
New operations over the tickets (printing a receipt, applying a discount,
calculating the order total) are added as separate visitor classes, so the
ticket classes do not change when a new operation is needed.

## Structure
- Element Interface: ITicket
- Concrete Elements: StandardTicket, VipTicket, ChildTicket
- Visitor Interface: ITicketVisitor
- Concrete Visitors: ReceiptVisitor, DiscountVisitor, TotalPriceVisitor
- Object Structure: ITicket[] order
- Client: Main

## How double dispatch works
`ticket.accept(visitor)` is executed in two steps:
1. Java chooses `accept` of the real ticket class (for example `VipTicket.accept`).
2. Inside it `visitor.visit(this)` is called. Here `this` is exactly a `VipTicket`,
   so the compiler picks `visit(VipTicket)`.

The Visitor interface declares one `visit` method per concrete element type:
`visit(StandardTicket)`, `visit(VipTicket)`, `visit(ChildTicket)`.

### Clean Code Requirements
#### 1. Meaningful names distinguishing Element vs. Visitor responsibilities:

Elements are named `StandardTicket`, `VipTicket`, `ChildTicket` and implement
`ITicket`: they are the data and only know how to `accept` a visitor. Visitors are
named by the operation they perform: `ReceiptVisitor`, `DiscountVisitor`,
`TotalPriceVisitor` and implement `ITicketVisitor`. From the name alone it is clear
whether a class is a thing that is visited or an operation that visits.

#### 2. No instanceof/type-checking chains anywhere:

There is no `instanceof`, casting or `if/switch` on the ticket class in the project.
`Main` works only with the `ITicket` abstraction and just calls
`ticket.accept(visitor)` in a loop. Double dispatch (`accept` -> `visitor.visit(this)`)
selects the correct method for each concrete ticket.

#### 3. Single Responsibility: each Concrete Visitor implements exactly one operation across all element types:

`ReceiptVisitor` only prints ticket information, `DiscountVisitor` only applies
discounts, `TotalPriceVisitor` only sums prices. Each of them implements `visit` for
all three ticket types. Ticket classes contain no printing, pricing or reporting logic.

#### 4. Minimal, well-justified encapsulation trade-offs:

Visitors need ticket data, so the Visitor pattern forces tickets to expose it. All
fields of the tickets stay `private`; visitors get access only through getters and
setters (`getPrice`, `getRow`, `isDrinkIncluded`, `getMaxAge`). `setPrice` is used
only by `DiscountVisitor`, because it is the only operation that changes the state.
No field is made public and no ticket logic is moved into visitors.

#### 5. Demonstrated extensibility: adding a third visitor requires no change:

`TotalPriceVisitor` was added as a third visitor without modifying
`StandardTicket`, `VipTicket`, `ChildTicket`, `ITicket`, `ReceiptVisitor` or
`DiscountVisitor`. New operation = new visitor class.
