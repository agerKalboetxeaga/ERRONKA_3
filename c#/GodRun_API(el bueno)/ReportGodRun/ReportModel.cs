using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ReportGodRun
{
    public class ReportModel
    {
        public int id { get; set; }
        public int puntuazioa { get; set; }
        public int kills { get; set; }
        public string time { get; set; }
        public string date { get; set; }
        public string name { get; set; }

        public ReportModel(int id, int puntuazioa, int kills, string time, string date, string eName)
        {
            this.id = id;
            this.puntuazioa = puntuazioa;
            this.kills = kills;
            this.time = time;
            this.date = date;
            this.name = eName;
        }
    }
   
}
