import java.util.*;

class Orders {

    String customer;
    String orderId;
    int units;
    int priority;

    public Orders() {

    }

    /**
     * @param customer
     * @param orderId
     * @param units
     * @param priority
     */
    public Orders(String customer, String orderId, int units, int priority) {
        this.customer = customer;
        this.orderId = orderId;
        this.units = units;
        this.priority = priority;
    }

    public void acceptInput(List<Orders> orders) {

        
        Map<String, List<Orders>> map = new HashMap<>();

        for (Orders od : orders) {
            if (!map.containsKey(od.customer)) {
                map.put(od.customer, new ArrayList<>());
            }
            map.get(od.customer).add(od);
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key), new Comparator<Orders>() {
                @Override
                public int compare(Orders o1, Orders o2) {
                    return o2.priority - o1.priority;
                }
               
            });
        }
        map.forEach((key, value) -> 
                    
                    
                    
                    
                    System.out.println(key + ":" + value));

       
        
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Order [customer=" + customer + ", orderId=" + orderId + ", priority=" + priority + ", units="
                + units
                + "]";
    }

}

class Fulfillment {
    String customer;
    String orderId;
    int units;

    public void processing() {

    }

    /**
     * @param customer
     * @param orderId
     * @param units
     */

    public Fulfillment(String customer, String orderId, int units) {
        this.customer = customer;
        this.orderId = orderId;
        this.units = units;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Fulfillment [customer=" + customer + ", orderId=" + orderId + ", units=" + units + "]";
    }

}

class Akshay {

    public static void main(String[] args) {
        Orders oderObject = new Orders();
        List<Fulfillment> resList = new ArrayList<>();
        List<Orders> orders = new ArrayList<>();

        Orders o1 = new Orders("Electric Car Co.", "1", 10, 1);
        Orders o2 = new Orders("Electric Car Co.", "2", 32, 25);
        Orders o3 = new Orders("Frontier Utilities", "3", 7, 3);
        Orders o4 = new Orders("Frontier Utilities", "4", 10, 1);
        Orders o5 = new Orders("Ralph Smart Phones", "5", 10, 99);

        orders.add(o1);
        orders.add(o2);
        orders.add(o3);
        orders.add(o4);
        orders.add(o5);

        oderObject.acceptInput(orders);

    }
}