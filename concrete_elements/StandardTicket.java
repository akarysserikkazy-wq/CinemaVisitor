package concrete_elements;

import interface_element.ITicket;
import interface_visitor.ITicketVisitor;

public class StandardTicket implements ITicket {

    private int price = 4000;
    private int row = 7;

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    @Override
    public void accept(ITicketVisitor visitor) {
        visitor.visit(this);
    }
}