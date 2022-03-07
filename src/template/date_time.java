/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package template;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;
import server.process_control.load_time_service;

/**
 *
 * @author user
 */
public class date_time {

    private JButton spp, setoran, tabungan, help, close;
    private boolean bl_spp, bl_setoran, bl_tabungan;

    public void service_button(JButton spp, JButton setoran, JButton tabungan, JButton help, JButton close) {
        this.spp = spp;
        this.setoran = setoran;
        this.tabungan = tabungan;
        this.help = help;
        this.close = close;
    }

    public void repair_button(boolean bl_spp, boolean bl_setoran, boolean bl_tabungan) {
        this.bl_spp = bl_spp;
        this.bl_setoran = bl_setoran;
        this.bl_tabungan = bl_tabungan;
    }

    public String date() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    public String time() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        @SuppressWarnings("UnusedAssignment")
        String zero_hou = "", zero_min = "", zero_sec = "";
        Date date_new = new Date();
        cal.setTime(date_new);
        int hou = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        if (hou <= 9) {
            zero_hou = "0";
        } else {
            zero_hou = "";
        }
        if (min <= 9) {
            zero_min = "0";
        } else {
            zero_min = "";
        }
        if (sec <= 9) {
            zero_sec = "0";
        } else {
            zero_sec = "";
        }
        String jam = zero_hou + Integer.toString(hou);
        String menit = zero_min + Integer.toString(min);
        String detik = zero_sec + Integer.toString(sec);
        return jam + ":" + menit + ":" + detik;
    }

    public void run_time(JLabel time, load_time_service lst) {
        @SuppressWarnings("Convert2Lambda")
        ActionListener taskPerformer = new ActionListener() {

            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sim_time = new SimpleDateFormat("HH:mm:ss");
            String jam, menit, detik, zero_hou = "", zero_min = "", zero_sec = "";
            int hou, min, sec;

            @Override
            public void actionPerformed(ActionEvent evt) {
                Date date_new = new Date();
                cal.setTime(date_new);
                hou = cal.get(Calendar.HOUR_OF_DAY);
                min = cal.get(Calendar.MINUTE);
                sec = cal.get(Calendar.SECOND);
                if (hou <= 9) {
                    zero_hou = "0";
                } else {
                    zero_hou = "";
                }
                if (min <= 9) {
                    zero_min = "0";
                } else {
                    zero_min = "";
                }
                if (sec <= 9) {
                    zero_sec = "0";
                } else {
                    zero_sec = "";
                }
                jam = zero_hou + Integer.toString(hou);
                menit = zero_min + Integer.toString(min);
                detik = zero_sec + Integer.toString(sec);
                time.setText(jam + ":" + menit + ":" + detik);
                if (lst.code().equals("server")) {
                    if (hou >= lst.time() && min >= 0 && sec >= 0 && Integer.parseInt(date().substring(0, 2)) > lst.date()) {
                        if (lst.type().equals("all")) {
                            spp.setEnabled(bl_spp);
                            setoran.setEnabled(bl_setoran);
                            tabungan.setEnabled(bl_tabungan);
                        } else {
                            spp.setEnabled(bl_spp);
                            //setoran.setEnabled(bl_setoran);
                            //tabungan.setEnabled(bl_tabungan);
                        }
                        help.setEnabled(true);
                    }
                    if (hou >= lst.close() && min >= 0 && sec >= 0) {
                        close.setEnabled(true);
                    }
                } else if (lst.code().equals("fasting")) {
                    if (hou >= lst.time_fasting() && min >= 0 && sec >= 0 && Integer.parseInt(date().substring(0, 2)) > lst.date_fasting()) {
                        if (lst.type().equals("all")) {
                            spp.setEnabled(bl_spp);
                            setoran.setEnabled(bl_setoran);
                            tabungan.setEnabled(bl_tabungan);
                        } else {
                            spp.setEnabled(bl_spp);
                            //setoran.setEnabled(bl_setoran);
                            tabungan.setEnabled(bl_tabungan);
                        }
                        help.setEnabled(true);
                    }
                    if (hou >= lst.close() && min >= 0 && sec >= 0) {
                        close.setEnabled(true);
                    }
                }
            }
        };
        new Timer(1000, taskPerformer).start();
    }

    public void run_time_display(JLabel time) {
        @SuppressWarnings("Convert2Lambda")
        ActionListener taskPerformer = new ActionListener() {

            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sim_time = new SimpleDateFormat("HH:mm:ss");
            String jam, menit, detik, zero_hou = "", zero_min = "", zero_sec = "";
            int hou, min, sec;

            @Override
            public void actionPerformed(ActionEvent evt) {
                Date date_new = new Date();
                cal.setTime(date_new);
                hou = cal.get(Calendar.HOUR_OF_DAY);
                min = cal.get(Calendar.MINUTE);
                sec = cal.get(Calendar.SECOND);
                if (hou <= 9) {
                    zero_hou = "0";
                } else {
                    zero_hou = "";
                }
                if (min <= 9) {
                    zero_min = "0";
                } else {
                    zero_min = "";
                }
                if (sec <= 9) {
                    zero_sec = "0";
                } else {
                    zero_sec = "";
                }
                jam = zero_hou + Integer.toString(hou);
                menit = zero_min + Integer.toString(min);
                detik = zero_sec + Integer.toString(sec);
                time.setText(jam + ":" + menit);
            }
        };
        new Timer(1000, taskPerformer).start();
    }

}
