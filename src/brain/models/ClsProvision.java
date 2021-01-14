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
public class ClsProvision implements IAction{
    private int id;
    private ClsFournisseur _fournisseur;
    private ClsProduit _Produit;
    private Date _dateProvision;
    private float _qty;

    public ClsProvision() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClsFournisseur getFournisseur() {
        return _fournisseur;
    }

    public void setFournisseur(ClsFournisseur _fournisseur) {
        this._fournisseur = _fournisseur;
    }

    public ClsProduit getProduit() {
        return _Produit;
    }

    public void setProduit(ClsProduit _Produit) {
        this._Produit = _Produit;
    }

    public Date getDateProvision() {
        return _dateProvision;
    }

    public void setDateProvision(Date _dateProvision) {
        this._dateProvision = _dateProvision;
    }

    public float getQty() {
        return _qty;
    }

    public void setQty(float _qty) {
        this._qty = _qty;
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
