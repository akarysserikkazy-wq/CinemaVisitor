import concrete_elements.ChildTicket;
import concrete_elements.StandardTicket;
import concrete_elements.VipTicket;
import concrete_visitors.DiscountVisitor;
import concrete_visitors.ReceiptVisitor;
import concrete_visitors.TotalPriceVisitor;
import interface_element.ITicket;
import interface_visitor.ITicketVisitor;

public class Main {
    public static void main(String[] args) {
        ITicket standard = new StandardTicket();
        ITicket vip = new VipTicket();
        ITicket child = new ChildTicket();

        ITicket[] order = {standard, vip, child};

        System.out.println("--- Original prices ---");

        ITicketVisitor receiptVisitor = new ReceiptVisitor();
        for (ITicket ticket : order) {
            ticket.accept(receiptVisitor);
        }

        System.out.println("\n--- After promo discount ---");

        ITicketVisitor discountVisitor = new DiscountVisitor();
        for (ITicket ticket : order) {
            ticket.accept(discountVisitor);
        }

        System.out.println("\n--- Order total ---");

        TotalPriceVisitor totalVisitor = new TotalPriceVisitor();
        for (ITicket ticket : order) {
            ticket.accept(totalVisitor);
        }
        System.out.println("Total: " + totalVisitor.getTotal() + " KZT");
    }
}
