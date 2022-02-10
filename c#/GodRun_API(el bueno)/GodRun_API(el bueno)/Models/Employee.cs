using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GodRun_API_el_bueno_.Models
{
    /// <summary>
    /// This is the model class for Employees
    /// </summary>
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
        
      
        public string name { get; set; }
        public string jobTitle { get; set; }
        public string workPhone { get; set; }
        public string workEmail { get; set; }

    }
}
