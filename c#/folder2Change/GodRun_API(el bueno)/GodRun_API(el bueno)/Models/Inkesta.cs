using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;

namespace GodRun_API_el_bueno_.Models
{
    public class Inkesta
    {
        [Key]
        public int id { get; set; }
        public string Galdera1 { get; set; }
        public string Galdera2 { get; set; }
        public string Galdera3 { get; set; }
        public string Galdera4 { get; set; }
        public string Galdera5 { get; set; }
        public string User { get; set; }
        public System.DateTime Data { get; set; }

    }
}
