using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GodRun_WebApi.Models
{
    public class Employee
    {
       // public int id { get; set;} no se si puedo omitirlo
        public string name { get; set; }
        public string jobTitle { get; set; }
        public int workPhone { get; set; }
        public string workEmail { get; set; }

    }
}
