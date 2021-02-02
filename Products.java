package lab28;

public class Products {
    private int weight;
    private int price;
    private TypeOfProduct typeOfProduct;
    Quality quality;


    public static Products makeProduct( TypeOfProduct typeOfProduct,int weight, int price, Quality quality){
        Products products = new Products();
        products.weight = weight;
        products.price = price;
        products.typeOfProduct = typeOfProduct;
        products.quality = quality;
        return products;
    }

    public double getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public TypeOfProduct getTypeOfProduct() {
        return typeOfProduct;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTypeOfProduct(TypeOfProduct typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "[" +
                " тип продукта = " + typeOfProduct +
                ", качество = " + quality +
                " вес = " + weight +
                ", цена = " + price +
                " ]";
    }
}
