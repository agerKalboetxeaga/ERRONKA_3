using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GodRun_WebApi.Models
{
    public class Partida
    {
        public int puntuazioa { get; set; }
        public int kills { get; set; }
        public string time { get; set; }
        public string date { get; set; }
        public Employee employee { get; set; }


    }
    
}
