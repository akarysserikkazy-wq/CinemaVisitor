package concrete_visitors;

import concrete_elements.ChildTicket;
import concrete_elements.StandardTicket;
import concrete_elements.VipTicket;
import interface_visitor.ITicketVisitor;

public class ReceiptVisitor implements ITicketVisitor {

    @Override
    public void visit(StandardTicket ticket) {
        System.out.println("Standard ticket, row " + ticket.getRow() + ": " + ticket.getPrice() + " KZT");
    }

    @Override
    public void visit(VipTicket ticket) {
        System.out.println("VIP ticket: " + ticket.getPrice() + " KZT, drink included: " + ticket.isDrinkIncluded());
    }

    @Override
    public void visit(ChildTicket ticket) {
        System.out.println("Child ticket: " + ticket.getPrice() + " KZT, up to " + ticket.getMaxAge() + " y.o.");
    }
}