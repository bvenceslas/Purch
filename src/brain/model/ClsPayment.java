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
public class ClsPayment {
    private int _id;
    private ClsPurchase _Purchase;
    private float _amount;
    private Date _datePayment;
    private ClsLogin _Login;
}
