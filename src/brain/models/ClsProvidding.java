/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain.models;

import brain.controller.IAction;
import java.sql.Date;

/**
 *
 * @author Brain
 */
public class ClsProvidding implements IAction{
    private int id;
    private ClsProvider _Provider;
    private ClsProduct _Product;
    private Date _dateProvidding;
    private float _qty;

    public ClsProvidding() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClsProvider getProvider() {
        return _Provider;
    }

    public void setProvider(ClsProvider _Provider) {
        this._Provider = _Provider;
    }

    public ClsProduct getProduct() {
        return _Product;
    }

    public void setProduct(ClsProduct _Product) {
        this._Product = _Product;
    }

    public Date getDateProvidding() {
        return _dateProvidding;
    }

    public void setDateProvidding(Date _dateProvidding) {
        this._dateProvidding = _dateProvidding;
    }

    public float getQty() {
        return _qty;
    }

    public void setQty(float _qty) {
        this._qty = _qty;
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
