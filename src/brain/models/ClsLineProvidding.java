/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain.models;

import brain.controller.IAction;

/**
 *
 * @author Brain
 */
public class ClsLineProvidding implements IAction{
    private ClsProvidding _Providding;
    private ClsProduct _Product;
    private float _qty, _price;

    public ClsLineProvidding() {
    }

    public ClsProvidding getProvidding() {
        return _Providding;
    }

    public void setProvidding(ClsProvidding _Providding) {
        this._Providding = _Providding;
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

    public float getPrice() {
        return _price;
    }

    public void setPrice(float _price) {
        this._price = _price;
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
