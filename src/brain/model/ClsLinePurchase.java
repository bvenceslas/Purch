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
public class ClsLinePurchase implements IAction{
    private ClsPurchase _Purchase;
    private ClsProduct _Product;
    private float _qty, _reduction;

    public ClsLinePurchase() {
    }

    public ClsPurchase getPurchase() {
        return _Purchase;
    }

    public void setPurchase(ClsPurchase _Purchase) {
        this._Purchase = _Purchase;
    }

    public ClsProduct getProduct() {
        return _Product;
    }

    public void setProduct(ClsProduct _Product) {
        this._Product = _Product;
    }

    public float getQty() {
        return _qty;
    }

    public void setQty(float _qty) {
        this._qty = _qty;
    }

    public float getReduction() {
        return _reduction;
    }

    public void setReduction(float _reduction) {
        this._reduction = _reduction;
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
