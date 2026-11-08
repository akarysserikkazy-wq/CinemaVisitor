package concrete_elements;

import interface_element.ITicket;
import interface_visitor.ITicketVisitor;

public class VipTicket implements ITicket {

    private int price = 15000;
    private boolean drinkIncluded = true;

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public boolean isDrinkIncluded() {
        return drinkIncluded;
    }
    public void setDrinkIncluded(boolean drinkIncluded) {
        this.drinkIncluded = drinkIncluded;
    }
    @Override
    public void accept(ITicketVisitor visitor) {
        visitor.visit(this);
    }
}