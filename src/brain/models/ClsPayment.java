/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain.models;

import brain.controller.ClsUpdateModel;
import brain.controller.IAction;
import java.sql.Date;

/**
 *
 * @author Brain
 */
public class ClsPayment implements IAction{
    private int _id;
    private ClsAchat _achat;
    private float _montant;
    private Date _datePayment;
    private ClsUser _User;

    public ClsPayment() {
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public ClsAchat getAchat() {
        return _achat;
    }

    public void setAchat(ClsAchat _achat) {
        this._achat = _achat;
    }

    public float getMontant() {
        return _montant;
    }

    public void setMontant(float _montant) {
        this._montant = _montant;
    }

    public Date getDatePayment() {
        return _datePayment;
    }

    public void setDatePayment(Date _datePayment) {
        this._datePayment = _datePayment;
    }

    public ClsUser getUser() {
        return _User;
    }

    public void setUser(ClsUser _User) {
        this._User = _User;
    }

    @Override
    public boolean saveData() throws Exception {       
        return ClsUpdateModel.updateData(this);
    }

    @Override
    public boolean deleteData() throws Exception {
        return ClsUpdateModel.deleteData("", getId());
    }
    
}
