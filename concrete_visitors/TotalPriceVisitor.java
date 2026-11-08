package concrete_visitors;

import concrete_elements.ChildTicket;
import concrete_elements.StandardTicket;
import concrete_elements.VipTicket;
import interface_visitor.ITicketVisitor;

public class TotalPriceVisitor implements ITicketVisitor {

    private int total = 0;

    @Override
    public void visit(StandardTicket ticket) {
        total += ticket.getPrice();
    }

    @Override
    public void visit(VipTicket ticket) {
        total += ticket.getPrice();
    }

    @Override
    public void visit(ChildTicket ticket) {
        total += ticket.getPrice();
    }

    public int getTotal() {
        return total;
    }
}