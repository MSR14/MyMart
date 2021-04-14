package com.example.mymart;

public class ModelCart {
    private String actualPrice,
             quantity, title, uid, productId,unitCost;

    public ModelCart() {
    }

    public String getActualPrice() {
        return actualPrice;
    }


    public void setActualPrice(String actualPrice) {
        this.actualPrice = actualPrice;
    }
    public String getUnitCost(){
        return unitCost;
    }
    public void setUnitCost(String unitCost){
        this.unitCost=unitCost;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public ModelCart(String actualPrice,
                      String quantity, String title, String uid, String productId,String unitCost) {
        this.actualPrice = actualPrice;
        this.quantity = quantity;
        this.title = title;
        this.uid = uid;
        this.productId = productId;
        this.unitCost=unitCost;
    }
}
