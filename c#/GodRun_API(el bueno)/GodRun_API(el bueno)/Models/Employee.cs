using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GodRun_WebApi.Models
{
    public class Employee
    {
        public Employee()
        {

        }
        
        public Employee (string name, string jobTitle, string workPhone, string workEmail)
        {
            this.name = name;
            this.jobTitle = jobTitle;
            this.workPhone = workPhone;
            this.workEmail = workEmail;
        }
        
       // public int id { get; set;} no se si puedo omitirlo
        public string name { get; set; }
        public string jobTitle { get; set; }
        public string workPhone { get; set; }
        public string workEmail { get; set; }

    }
}
