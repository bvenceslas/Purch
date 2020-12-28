/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain.model;

import java.sql.Date;

/**
 *
 * @author Brain
 */
public class ClsProvidding {
    private int _id;
    private ClsProvider _Provider;
    private Date dateProvidding;

    public ClsProvidding() {
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public ClsProvider getProvider() {
        return _Provider;
    }

    public void setProvider(ClsProvider _Provider) {
        this._Provider = _Provider;
    }

    public Date getDateProvidding() {
        return dateProvidding;
    }

    public void setDateProvidding(Date dateProvidding) {
        this.dateProvidding = dateProvidding;
    }
    
}
