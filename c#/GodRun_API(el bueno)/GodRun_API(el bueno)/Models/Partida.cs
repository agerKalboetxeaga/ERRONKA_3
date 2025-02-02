﻿using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GodRun_API_el_bueno_.Models
{
    /// <summary>
    /// This is the model class for Partida
    /// </summary>
    public class Partida
    {
        public Partida()
        {

        }
       
        public Partida(int puntuazioa, int kills, string time, string date, Employee employee)
        {
            this.puntuazioa = puntuazioa;
            this.kills = kills;
            this.time = time;
            this.date = date;
            this.employee = employee;
        }
       
        public int puntuazioa { get; set; }
        public int kills { get; set; }
        public string time { get; set; }
        public string date { get; set; }
        public Employee employee { get; set; }


    }
    
}
