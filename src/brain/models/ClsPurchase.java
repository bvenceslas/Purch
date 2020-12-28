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
public class ClsPurchase implements IAction{
    private int _id;
    private ClsClient _Client;
    private ClsLogin _Login;
    private Date _datePurchase;

    public ClsPurchase() {
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public ClsClient getClient() {
        return _Client;
    }

    public void setClient(ClsClient _Client) {
        this._Client = _Client;
    }

    public ClsLogin getLogin() {
        return _Login;
    }

    public void setLogin(ClsLogin _Login) {
        this._Login = _Login;
    }

    public Date getDatePurchase() {
        return _datePurchase;
    }

    public void setDatePurchase(Date _datePurchase) {
        this._datePurchase = _datePurchase;
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
