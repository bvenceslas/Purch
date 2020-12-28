/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain.model;

import brain.controller.IAction;

/**
 *
 * @author Brain
 */
public class ClsProduct implements IAction{
    private int _id;
    private String _product, _quantification;
    private float _price, _stock;
    private ClsCategory _Category;

    public ClsProduct() {
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getProduct() {
        return _product;
    }

    public void setProduct(String _product) {
        this._product = _product;
    }

    public String getQuantification() {
        return _quantification;
    }

    public void setQuantification(String _quantification) {
        this._quantification = _quantification;
    }

    public float getPrice() {
        return _price;
    }

    public void setPrice(float _price) {
        this._price = _price;
    }

    public float getStock() {
        return _stock;
    }

    public void setStock(float _stock) {
        this._stock = _stock;
    }

    public ClsCategory getCategory() {
        return _Category;
    }

    public void setCategory(ClsCategory _Category) {
        this._Category = _Category;
    }

    @Override
    public boolean saveData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
