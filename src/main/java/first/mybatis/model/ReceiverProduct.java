package first.mybatis.model;

public class ReceiverProduct {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.RECEIVER_PRODUCT.RECEIVER_ID
     *
     * @mbg.generated Thu Mar 26 18:25:57 EET 2020
     */
    private Integer receiverId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.RECEIVER_PRODUCT.PRODUCT_ID
     *
     * @mbg.generated Thu Mar 26 18:25:57 EET 2020
     */
    private Integer productId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.RECEIVER_PRODUCT.RECEIVER_ID
     *
     * @return the value of PUBLIC.RECEIVER_PRODUCT.RECEIVER_ID
     *
     * @mbg.generated Thu Mar 26 18:25:57 EET 2020
     */
    public Integer getReceiverId() {
        return receiverId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.RECEIVER_PRODUCT.RECEIVER_ID
     *
     * @param receiverId the value for PUBLIC.RECEIVER_PRODUCT.RECEIVER_ID
     *
     * @mbg.generated Thu Mar 26 18:25:57 EET 2020
     */
    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.RECEIVER_PRODUCT.PRODUCT_ID
     *
     * @return the value of PUBLIC.RECEIVER_PRODUCT.PRODUCT_ID
     *
     * @mbg.generated Thu Mar 26 18:25:57 EET 2020
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.RECEIVER_PRODUCT.PRODUCT_ID
     *
     * @param productId the value for PUBLIC.RECEIVER_PRODUCT.PRODUCT_ID
     *
     * @mbg.generated Thu Mar 26 18:25:57 EET 2020
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}