package jp.co.veritrans.airweb.mdk.bean;

import java.io.Serializable;

/**
 * 商品情報を保持するBean
 */
public class CommodityDetail implements Serializable {

    /**
     * serial version UID.
     */
    private static final long serialVersionUID = -87612566231259766L;

    /**
     * 商品ID
     */
    private String commodityId;

    /**
     * JANコード
     */
    private String janCode;

    /**
     * 商品名
     */
    private String commodityName;

    /**
     * 価格
     */
    private Integer commodityUnit;

    /**
     * 数量
     */
    private Integer commodityNum;

    /**
     * コンストラクタ
     */
    public CommodityDetail() {
    }

    /**
     * コンストラクタ
     * 
     * @param commodityId 商品ID
     * @param janCode JANコード
     * @param commodityName 商品名
     * @param commodityUnit 価格
     * @param commodityNum 数量
     */
    public CommodityDetail(String commodityId, String janCode, String commodityName, Integer commodityUnit,
            Integer commodityNum) {
        this.setCommodityId(commodityId);
        this.setJanCode(janCode);
        this.setCommodityName(commodityName);
        this.setCommodityUnit(commodityUnit);
        this.setCommodityNum(commodityNum);
    }

    /**
     * commodityIdの取得
     * 
     * @return the commodityId of String
     */
    public String getCommodityId() {
        return commodityId;
    }

    /**
     * commodityIdの設定
     * 
     * @param commodityId the commodityId to set
     */
    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    /**
     * janCodeの取得
     * 
     * @return the janCode of String
     */
    public String getJanCode() {
        return janCode;
    }

    /**
     * janCodeの設定
     * 
     * @param janCode the janCode to set
     */
    public void setJanCode(String janCode) {
        this.janCode = janCode;
    }

    /**
     * commodityNameの取得
     * 
     * @return the commodityName of String
     */
    public String getCommodityName() {
        return commodityName;
    }

    /**
     * commodityNameの設定
     * 
     * @param commodityName the commodityName to set
     */
    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    /**
     * commodityUnitの取得
     * 
     * @return the commodityUnit of String
     */
    public Integer getCommodityUnit() {
        return commodityUnit;
    }

    /**
     * commodityUnitの設定
     * 
     * @param commodityUnit the commodityUnit to set
     */
    public void setCommodityUnit(Integer commodityUnit) {
        this.commodityUnit = commodityUnit;
    }

    /**
     * commodityNumの取得
     * 
     * @return the commodityNum of String
     */
    public Integer getCommodityNum() {
        return commodityNum;
    }

    /**
     * commodityNumの設定
     * 
     * @param commodityNum the commodityNum to set
     */
    public void setCommodityNum(Integer commodityNum) {
        this.commodityNum = commodityNum;
    }

}
