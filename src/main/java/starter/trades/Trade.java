package starter.trades;

public class Trade {
    private final Long id;
    private final String security;
    private final String buySell;
    private final Long quantity;
    private final Long priceInCents;
    private final Long totalCostInCents;

    public Trade(Long id, String security, String buySell, Long quantity, Long priceInCents, Long totalCostInCents) {
        this.id = id;
        this.security = security;
        this.buySell = buySell;
        this.quantity = quantity;
        this.priceInCents = priceInCents;
        this.totalCostInCents = totalCostInCents;
    }

    public Long getId() {
        return id;
    }

    public String getSecurity() {
        return security;
    }

    public String getBuySell() {
        return buySell;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Long getPriceInCents() {
        return priceInCents;
    }

    public Long getTotalCostInCents() {
        return totalCostInCents;
    }


    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", security='" + security + '\'' +
                ", buySell='" + buySell + '\'' +
                ", quantity=" + quantity +
                ", priceInCents=" + priceInCents +
                ", totalCostInCents=" + totalCostInCents +
                '}';
    }
}
