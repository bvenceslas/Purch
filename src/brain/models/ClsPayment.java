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
public class ClsPayment implements IAction{
    private int _id;
    private ClsAchat _Purchase;
    private float _amount;
    private Date _datePayment;
    private ClsUser _Login;

    public ClsPayment() {
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public ClsAchat getPurchase() {
        return _Purchase;
    }

    public void setPurchase(ClsAchat _Purchase) {
        this._Purchase = _Purchase;
    }

    public float getAmount() {
        return _amount;
    }

    public void setAmount(float _amount) {
        this._amount = _amount;
    }

    public Date getDatePayment() {
        return _datePayment;
    }

    public void setDatePayment(Date _datePayment) {
        this._datePayment = _datePayment;
    }

    public ClsUser getLogin() {
        return _Login;
    }

    public void setLogin(ClsUser _Login) {
        this._Login = _Login;
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
