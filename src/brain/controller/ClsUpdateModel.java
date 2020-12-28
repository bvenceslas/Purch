/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain.controller;

import brain.models.ClsAccessSetup;
import brain.models.ClsCategory;
import brain.models.ClsClient;
import brain.models.ClsGamme;
import brain.models.ClsLineProvidding;
import brain.models.ClsLinePurchase;
import brain.models.ClsLogin;
import brain.models.ClsPayment;
import brain.models.ClsProduct;
import brain.models.ClsProvidding;
import brain.models.ClsProvider;
import brain.models.ClsPurchase;
import brain.models.ClsQuantification;
import brain.models.ClsSoft;
import java.sql.PreparedStatement;

/**
 *
 * @author Brain
 */
public class ClsUpdateModel {
    
    public static boolean updateData(Object obj) throws ClassNotFoundException, Exception{
        if (obj instanceof ClsAccessSetup) {
            ClsAccessSetup acset = (ClsAccessSetup)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_ACCESS_SETUP ?, ?");
            ps.setInt(1, acset.getId());
            ps.setString(2, acset.getAccessLevel());
            ps.executeUpdate();
            ps.close();
            return true;
            
        } else if (obj instanceof ClsCategory) {
            ClsCategory cat = (ClsCategory)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_CATEGORY ?, ?, ?");
            ps.setInt(1, cat.getId());
            ps.setString(2, cat.getCategory());
            ps.setString(3, cat.getGamme().getGamme());
            ps.executeUpdate();
            ps.close();
            return true;
        } else if (obj instanceof ClsClient) {
            ClsClient cli = (ClsClient)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_CLIENT ?, ?, ?, ?, ?");
            ps.setInt(1, cli.getId());
            ps.setString(2, cli.getNom());
            ps.setString(3, cli.getPrenom());
            ps.setString(4, cli.getContact());
            ps.setString(5, cli.getAddresse());
            ps.executeUpdate();
            ps.close();
            return true;
        } else if (obj instanceof ClsGamme) {
            ClsGamme gam = (ClsGamme)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_GAMME ?, ?");
            ps.setInt(1, gam.getId());
            ps.setString(2, gam.getGamme());
            ps.executeUpdate();
            ps.close();
            return true;
        }else if (obj instanceof ClsLineProvidding) {
            ClsLineProvidding lineProv = (ClsLineProvidding)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_LINE_PROVIDDING ?, ?, ?, ?");
            ps.setInt(1, lineProv.getProvidding().getId());
            ps.setString(2, lineProv.getProduct().getProduct());
            ps.setFloat(3, lineProv.getQty());
            ps.setFloat(4, lineProv.getPrice());
            ps.executeUpdate();
            ps.close();
            return true;
        }else if (obj instanceof ClsLinePurchase) {
            ClsLinePurchase linePurch = (ClsLinePurchase)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_LINE_PURCHASE ?, ?, ?, ?");
            ps.setInt(1, linePurch.getPurchase().getId());
            ps.setString(2, linePurch.getProduct().getProduct());
            ps.setFloat(3, linePurch.getQty());
            ps.setFloat(4, linePurch.getReduction());
            ps.executeUpdate();
            ps.close();
            return true;
        } else if (obj instanceof ClsLogin) {
            ClsLogin log = (ClsLogin)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_LOGIN ?, ?, ?");
            ps.setString(1, log.getUsername());
            ps.setString(2, log.getPwd());
            ps.setString(3, log.getAccessLevel());
            ps.executeUpdate();
            ps.close();
            return true;
        } else if (obj instanceof ClsPayment) {
            ClsPayment pay = (ClsPayment)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_PAYMENT ?, ?, ?, ?, ?");
            ps.setInt(1, pay.getId());
            ps.setInt(2, pay.getPurchase().getId());
            ps.setFloat(3, pay.getAmount());
            ps.setDate(4, pay.getDatePayment());
            ps.setString(5, pay.getLogin().getUsername());
            ps.executeUpdate();
            ps.close();
            return true;
        } else if (obj instanceof ClsProduct) {
            ClsProduct prod = (ClsProduct)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_PRODUCT ?, ?, ?, ?, ?, ?");
            ps.setInt(1, prod.getId());
            ps.setString(2, prod.getProduct());
            ps.setString(3, prod.getQuantification());
            ps.setFloat(4, prod.getPrice());
            ps.setFloat(5, prod.getStock());
            ps.setString(6, prod.getCategory().getCategory());
            ps.executeUpdate();
            ps.close();
            return true;
        } else if (obj instanceof ClsProvidding){            
            ClsProvidding providding = (ClsProvidding)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_PROVIDDING ?, ?, ?");
            ps.setInt(1, providding.getId());
            ps.setString(2, providding.getProvider().getNom());
            ps.setDate(3, providding.getDateProvidding());
            ps.executeUpdate();
            ps.close();
            return true;
        } else if (obj instanceof ClsProvider) {
            ClsProvider provider = (ClsProvider)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_PROVIDER ?, ?, ?, ?, ?");
            ps.setInt(1, provider.getId());
            ps.setString(2, provider.getNom());
            ps.setString(3, provider.getPrenom());
            ps.setString(4, provider.getContact());
            ps.setString(5, provider.getAddresse());
            ps.executeUpdate();
            ps.close();
            return true;
        } else if (obj instanceof ClsPurchase) {
            ClsPurchase purchase = (ClsPurchase)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_PURCHASE ?, ?, ?, ?");
            ps.setInt(1, purchase.getId());
            ps.setString(2, purchase.getClient().getNom());
            ps.setString(3, purchase.getLogin().getUsername());
            ps.setDate(4, purchase.getDatePurchase());
            ps.executeUpdate();
            ps.close();
            return true;
        } else if (obj instanceof ClsQuantification) {
            ClsQuantification quant = (ClsQuantification)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_QUANTIFICATION ?, ?");
            ps.setInt(1, quant.getId());
            ps.setString(2, quant.getQuantification());
            ps.executeUpdate();
            ps.close();
            return true;
        } else if (obj instanceof ClsSoft) {
            ClsSoft soft = (ClsSoft)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_SOFT ?, ?");
            ps.setInt(1, soft.getId());
            ps.setString(2, soft.getSoft());
            ps.executeUpdate();
            ps.close();
            return true;
        }
        return false;
    
    }
}
