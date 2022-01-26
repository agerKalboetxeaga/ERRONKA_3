using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace GodRun_WebApi.Models
{
    public class Comments
    {
        [Key]
        public int comment_Id { get; set; }
        public string comment { get; set; }
        public string username { get; set; }
        public System.DateTime date { get; set; }

    }
}
