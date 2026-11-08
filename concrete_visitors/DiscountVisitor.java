package concrete_visitors;

import concrete_elements.ChildTicket;
import concrete_elements.StandardTicket;
import concrete_elements.VipTicket;
import interface_visitor.ITicketVisitor;

public class DiscountVisitor implements ITicketVisitor {

    @Override
    public void visit(StandardTicket ticket) {
        ticket.setPrice(ticket.getPrice() * 90 / 100);
        System.out.println("Standard ticket, row " + ticket.getRow() + ": " + ticket.getPrice() + " KZT");
    }

    @Override
    public void visit(VipTicket ticket) {
        ticket.setPrice(ticket.getPrice() * 95 / 100);
        System.out.println("VIP ticket: " + ticket.getPrice() + " KZT");
    }

    @Override
    public void visit(ChildTicket ticket) {
        ticket.setPrice(ticket.getPrice() * 80 / 100);
        System.out.println("Child ticket: " + ticket.getPrice() + " KZT");
    }
}