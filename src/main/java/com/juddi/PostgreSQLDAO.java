package com.juddi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class PostgreSQLDAO {

    public List<Coffee> getCoffees() {
        List<Coffee> result = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()){
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from coffee");

            while (rs.next()) {
                String name = rs.getString("name");
                String country = rs.getString("country");
                int cost = rs.getInt("cost");
                int sort = rs.getInt("sort");
                int strength = rs.getInt("strength");

                Coffee coffee = new Coffee(name, country, cost, CoffeeSort.values()[sort], strength);
                result.add(coffee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }


    public List<Coffee> getFilteredCoffees(CoffeeFilter filter) {
        List<Coffee> result = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()){
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from coffee");

            while (rs.next()) {
                String name = rs.getString("name");
                String country = rs.getString("country");
                int cost = rs.getInt("cost");
                CoffeeSort sort = CoffeeSort.values()[rs.getInt("sort")];
                int strength = rs.getInt("strength");

                if (!isNullOrBlank(filter.getName())) {
                    if (!name.equalsIgnoreCase(filter.getName())) continue;
                }

                if (!isNullOrBlank(filter.getCountry())) {
                    if (!country.equalsIgnoreCase(filter.getCountry())) continue;
                }

                if (filter.getCost() != null) {
                    if (cost != filter.getCost()) continue;
                }

                if (filter.getSort() != null) {
                    if (sort != filter.getSort()) continue;
                }

                if (filter.getStrength() != null) {
                    if (strength != filter.getStrength()) continue;
                }

                Coffee coffee = new Coffee(name, country, cost, sort, strength);
                result.add(coffee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    private boolean isNullOrBlank(String string) {
        return string == null || string.isEmpty();
    }
}