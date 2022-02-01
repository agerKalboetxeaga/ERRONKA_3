using AspNetCore.Reporting;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Text;
using GodRun_API_el_bueno_.Models;
using GodRun_API_el_bueno_.ViewModels;
using GodRun_API_el_bueno_.Services;

namespace GodRun_API_el_bueno_.Controllers
{
    public class ReportController : Controller
    {
        private readonly IWebHostEnvironment _webHostEnviroment;
        private readonly IComentsService _comentsService;
        private readonly IPartidaService _partidaService;
        public ReportController(IWebHostEnvironment webHostEnviroment, IComentsService comentsService, IPartidaService partidaService)
        {
            _webHostEnviroment = webHostEnviroment;
            _comentsService = comentsService;
            _partidaService = partidaService;
        }
        /// <summary>
        /// Hall of Shame "PDF creator"
        /// </summary>
        /// <returns>A view of the PDF</returns>
        public async Task<IActionResult> PrintHoF()
        {
            Encoding.RegisterProvider(CodePagesEncodingProvider.Instance);

            List<Employee> employees = new List<Employee>();
            IList<Partida> partidak = new List<Partida>();
             partidak = await _partidaService.GetHoF();
            


            foreach (var partida in partidak)
            {
                employees.Add(partida.employee);
            }

            string mimtype = "";
            int extension = 1;
            var PATH = $"{_webHostEnviroment.WebRootPath}\\Reports\\Report1.rdlc";

            Dictionary<string, string> parameters = new Dictionary<string, string>();
            parameters.Add("Param1", HttpContext.User.Identity.Name + "entzat opari hau");


            LocalReport localReport = new LocalReport(PATH);
            localReport.AddDataSource("PartidaDataSet", partidak);
            localReport.AddDataSource("EmployeeDataSet", employees);

            var result = localReport.Execute(RenderType.Pdf, extension, parameters, mimtype);

            return File(result.MainStream, "application/pdf");
        }

        /// <summary>
        /// Hall of Fame "PDF creator"
        /// </summary>
        /// <returns>A view of the PDF</returns>
        public async Task<IActionResult> PrintHoS()
        {
            Encoding.RegisterProvider(CodePagesEncodingProvider.Instance);

            List<Employee> employees = new List<Employee>();
            IList<Partida> partidak = new List<Partida>();
            partidak = await _partidaService.GetHoS();



            foreach (var partida in partidak)
            {
                employees.Add(partida.employee);
            }

            string mimtype = "";
            int extension = 1;
            var PATH = $"{_webHostEnviroment.WebRootPath}\\Reports\\Report2.rdlc";

            Dictionary<string, string> parameters = new Dictionary<string, string>();
            parameters.Add("Param1", HttpContext.User.Identity.Name + "entzat opari txar hau");


            LocalReport localReport = new LocalReport(PATH);
            localReport.AddDataSource("PartidaDataSet", partidak);
            localReport.AddDataSource("EmployeeDataSet", employees);

            var result = localReport.Execute(RenderType.Pdf, extension, parameters, mimtype);

            return File(result.MainStream, "application/pdf");
        }

        public IActionResult Index()
        {
            return View();
        }
    }
}
