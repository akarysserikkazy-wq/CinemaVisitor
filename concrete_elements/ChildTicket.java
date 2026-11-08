package concrete_elements;

import interface_element.ITicket;
import interface_visitor.ITicketVisitor;

public class ChildTicket implements ITicket {

    private int price = 2000;
    private int maxAge = 15;

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getMaxAge() {
        return maxAge;
    }
    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }
    @Override
    public void accept(ITicketVisitor visitor) {
        visitor.visit(this);
    }
}