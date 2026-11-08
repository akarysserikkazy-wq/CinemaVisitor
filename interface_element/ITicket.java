package interface_element;

import interface_visitor.ITicketVisitor;

public interface ITicket {
    void accept(ITicketVisitor visitor);
}
