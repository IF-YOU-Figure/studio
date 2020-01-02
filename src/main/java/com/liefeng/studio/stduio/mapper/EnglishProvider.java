package com.liefeng.studio.stduio.mapper;

public class EnglishProvider {

        public String setWeek(String user_name, String weekDay, String clock ,String week ) {
            String sql = "UPDATE english SET ";
            switch (weekDay) {
                case "monday":
                    sql += "monday = #{clock} WHERE user_name=#{user_name} AND week=#{week}";
                    break;
                case "tuesday":
                    sql += "tuesday = #{clock} WHERE user_name=#{user_name} AND week=#{week}";
                    break;
                case "wednesday":
                    sql += "wednesday = #{clock} WHERE user_name=#{user_name} AND week=#{week}";
                    break;
                case "thursday":
                    sql += "thursday = #{clock} WHERE user_name=#{user_name} AND week=#{week}";
                    break;
                case "friday":
                    sql += "friday = #{clock} WHERE user_name=#{user_name} AND week=#{week}";
                    break;
                case "saturday":
                    sql += "saturday = #{clock} WHERE user_name=#{user_name} AND week=#{week}";
                    break;
                case "sunday":
                    sql += "sunday = #{clock} WHERE user_name=#{user_name} AND week=#{week}";
                    break;
            }
            return sql;
        }


    public String createWeek(String user_name, String weekDay, String clock ,String week ) {
        String sql = "INSERT INTO english (user_name,";
        switch (weekDay) {
            case "monday":
                sql += "monday,week) VALUES (#{user_name},#{clock},#{week})";
                break;
            case "tuesday":
                sql += "tuesday,week) VALUES (#{user_name},#{clock},#{week})";
                break;
            case "wednesday":
                sql += "wednesday,week) VALUES (#{user_name},#{clock},#{week})";
                break;
            case "thursday":
                sql += "thursday,week) VALUES (#{user_name},#{clock},#{week})";
                break;
            case "friday":
                sql += "friday,week) VALUES (#{user_name},#{clock},#{week})";
                break;
            case "saturday":
                sql += "saturday,week) VALUES (#{user_name},#{clock},#{week})";
                break;
            case "sunday":
                sql += "sunday,week) VALUES (#{user_name},#{clock},#{week})";
                break;
        }
        return sql;
    }

}


