/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain.models;

import brain.controller.ClsUpdateModel;
import brain.controller.IAction;

/**
 *
 * @author Brain
 */
public class ClsCategory implements IAction{
    private int _id;
    private String _category;
    private ClsGamme _Gamme;

    public ClsCategory() {
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getCategory() {
        return _category;
    }

    public void setCategory(String _category) {
        this._category = _category;
    }

    public ClsGamme getGamme() {
        return _Gamme;
    }

    public void setGamme(ClsGamme _Gamme) {
        this._Gamme = _Gamme;
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
