﻿public class Utilisateur {    public static void main(String[] args) {        DonneesMeteo donneesMeteo = new DonneesMeteo();        donneesMeteo.setTemperature(24.00);        donneesMeteo.setPression(1015.00);        donneesMeteo.setTauxHumidite(8.20);        WidgetMeteo widgetMeteo = new WidgetMeteo(                donneesMeteo);        PluginMeteo pluginMeteo = new PluginMeteo(                donneesMeteo);        donneesMeteo.setTemperature(25.00);
		donneesMeteo.setPression(1010.00);    }}