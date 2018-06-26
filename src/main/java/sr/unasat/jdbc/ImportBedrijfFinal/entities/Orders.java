package sr.unasat.jdbc.ImportBedrijfFinal.entities;

public class Orders {
    private int order_id;
    private String item;
    private int quantity;
    private int order_number;
    private String purchase_date;
    private Customer customer;
    private Store store;
    //private int store_id;
    //private int customer_id;

    public Orders(int order_id,
                  String item,
                  int quantity,
                  int order_number,
                  String purchase_date,
                  Customer customer,
                  Store store) {
        this.order_id = order_id;
        this.item = item;
        this.quantity = quantity;
        this.order_number = order_number;
        this.purchase_date = purchase_date;
        this.customer = customer;
        this.store = store;
    }

    public Orders(int quantity,
                  Customer customer,
                  Store store) {
        this.quantity = quantity;
        this.customer = customer;
        this.store = store;
    }

    public Orders(int order_id,
                  int quantity,
                  String item,
                  Customer customer,
                  Store store) {
        this.order_id = getOrder_id();
        this.quantity = getQuantity();
        this.item = getItem();
        this.customer = customer;
        this.store = store;
    }

    //public Orders(int id, String quantity, String item, int cusid, String customerName, int order_id, String storeName) {
    //    this.order_id = order_id;
   // }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public String getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "\033[1m\nOrders placed: \033[0m" +
                "\nOrder ID: " + order_id +
                "\nItem: " + item +
                "\nQuantity: " + quantity +
                "\nOrder Number: " + order_number +
                "\nPurchase Date: " + purchase_date +
                customer +
                store;
    }
}