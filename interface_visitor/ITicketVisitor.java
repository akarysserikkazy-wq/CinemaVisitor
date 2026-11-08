package interface_visitor;

import concrete_elements.ChildTicket;
import concrete_elements.StandardTicket;
import concrete_elements.VipTicket;

public interface ITicketVisitor {
    void visit(StandardTicket ticket);
    void visit(VipTicket ticket);
    void visit(ChildTicket ticket);
}
