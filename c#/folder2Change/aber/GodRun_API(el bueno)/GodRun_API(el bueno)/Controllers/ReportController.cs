using AspNetCore.Reporting;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Text;

namespace GodRun_API_el_bueno_.Controllers
{
    public class ReportController : Controller
    {
        private readonly IWebHostEnvironment _webHostEnviroment;
        public ReportController(IWebHostEnvironment webHostEnviroment)
        {
            _webHostEnviroment = webHostEnviroment;
        }
        public IActionResult PrintIt()
        {
            Encoding.RegisterProvider(CodePagesEncodingProvider.Instance);

            string mimtype = "";
            int extension = 1;
            var PATH = $"{_webHostEnviroment.WebRootPath}\\Reports\\Resport1.rdlc";

            Dictionary<string, string> parameters = new Dictionary<string, string>();
            parameters.Add("Param1", HttpContext.User.Identity.Name + "entzat opari hau");

            LocalReport localReport = new LocalReport(PATH);
            var result = localReport.Execute(RenderType.Pdf, extension, parameters, mimtype);

            return File(result.MainStream, "application/pdf");
        }



        public IActionResult Index()
        {
            return View();
        }
    }
}
