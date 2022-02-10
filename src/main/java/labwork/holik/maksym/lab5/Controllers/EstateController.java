package labwork.holik.maksym.lab5.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import labwork.holik.maksym.lab2.*;
import labwork.holik.maksym.lab3.*;
import labwork.holik.maksym.lab4.DAO.*;
import labwork.holik.maksym.lab5.Form.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EstateController {
    private IMyDAO dao = DAOFactory.getDAOInstance(TypeDAO.MySQL);
    //private IMyDAO dao = DAOFactory.getDAOInstance(TypeDAO.COLLECTION);

    @RequestMapping(value={"/"},method ={RequestMethod.GET,RequestMethod.POST})
    public String showHomePage(){
        return "home_page";
    }

    @RequestMapping(value = { "/apartments" }, method = { RequestMethod.GET, RequestMethod.POST })
    public String showAllApartments(Model model) {
        MyListImpl mylist = dao.getALLapartments();
        List<Apartment> list = new ArrayList<>();
        for(Object estate: mylist)list.add((Apartment)estate);
        model.addAttribute("allApartments", list);

        return "apartments_page";
    }

    @RequestMapping(value = {  "/offices" }, method = { RequestMethod.GET, RequestMethod.POST })
    public String showAllOffices(Model model) {
        MyListImpl mylist = dao.getALLoffices();
        List<Office> list = new ArrayList<>();
        for(Object estate: mylist)list.add((Office)estate);
        model.addAttribute("allOffices", list);

        return "offices_page";
    }

    @RequestMapping(value = { "/apartmentsByOfficeDistrict" }, method = RequestMethod.GET)
    public String showGetApartmentsByOfficeDistrictView(Model model) {
        GetApartmentsByOfficeDistrictForm getApartmentsByOfficeDistrictForm = new GetApartmentsByOfficeDistrictForm();
        model.addAttribute("getApartmentsByOfficeDistrictForm", getApartmentsByOfficeDistrictForm);

        return "getApartmentsByOfficeDistrictPage";
    }

    @RequestMapping(value = { "/apartmentsByOfficeDistrict" }, method = RequestMethod.POST)
    public String getApartmentsByOfficeDistrict(Model model, GetApartmentsByOfficeDistrictForm getApartmentsByOfficeDistrictForm) {

        MyListImpl mylist = dao.getAps_samedistrict_theOffice(getApartmentsByOfficeDistrictForm.getOfficeName());
        List<Apartment> list = new ArrayList<>();
        for(Object estate: mylist)list.add((Apartment)estate);
        model.addAttribute("allApartments", list);

        return "apartments_page";
    }

    @RequestMapping(value = { "/officesByApartmentDistrict" }, method = RequestMethod.GET)
    public String showGetOfficesByApartmentDistrictView(Model model) {
        GetOfficesByApartmentDistrictForm getOfficesByApartmentDistrictForm = new GetOfficesByApartmentDistrictForm();
        model.addAttribute("getOfficesByApartmentDistrictForm", getOfficesByApartmentDistrictForm);

        return "getOfficesByApartmentDistrictPage";
    }

    @RequestMapping(value = { "/officesByApartmentDistrict" }, method = RequestMethod.POST)
    public String getOfficesByApartmentDistrict(Model model, GetOfficesByApartmentDistrictForm getOfficesByApartmentDistrictForm) {
        MyListImpl mylist = dao.getOffices_samedistrict_theAps(getOfficesByApartmentDistrictForm.getApartmentName());
        List<Office> list = new ArrayList<>();
        for(Object estate: mylist)list.add((Office)estate);
        model.addAttribute("allOffices", list);

        return "offices_page";
    }

    @RequestMapping(value = {"/apartmentsByPurchaseRange"}, method = RequestMethod.GET)
    public String showGetApartmentsByPurchaseRangeView(Model model){
        GetApartmentsByPurchaseRangeForm getApartmentsByPurchaseRangeForm = new GetApartmentsByPurchaseRangeForm();
        model.addAttribute("getApartmentsByPurchaseRangeForm",getApartmentsByPurchaseRangeForm);

        return "getApartmentsByPurchaseRangePage";
    }

    @RequestMapping(value = {"/apartmentsByPurchaseRange"}, method = RequestMethod.POST)
    public String getApartmentsByPurchaseRange(Model model, GetApartmentsByPurchaseRangeForm getApartmentsByPurchaseRangeForm){
       MyListImpl mylist = dao.getAps_by_purchase_range(getApartmentsByPurchaseRangeForm.getMin(),getApartmentsByPurchaseRangeForm.getMax()) ;
       List<Apartment> list = new ArrayList<>();
        for(Object estate: mylist)list.add((Apartment) estate);
        model.addAttribute("allApartments", list);

        return "apartments_page";
    }

    @RequestMapping(value = {"/officesByCapacityGreaterThan"}, method = RequestMethod.GET)
    public String showGetOfficesByCapacityGreaterThanView(Model model){
        GetOfficesByCapacityGreaterThanForm getOfficesByCapacityGreaterThanForm  = new GetOfficesByCapacityGreaterThanForm();
        model.addAttribute("getOfficesByCapacityGreaterThanForm",getOfficesByCapacityGreaterThanForm);

        return "getOfficesByCapacityGreaterThanPage";
    }

    @RequestMapping(value = {"/officesByCapacityGreaterThan"}, method = RequestMethod.POST)
    public String getOfficesByCapacityGreaterThan(Model model, GetOfficesByCapacityGreaterThanForm getOfficesByCapacityGreaterThanForm){
        MyListImpl mylist = dao.getOffices_where_capacity_greater_than_desc(getOfficesByCapacityGreaterThanForm.getMincapacity());
        List<Office> list = new ArrayList<>();
        for(Object estate: mylist)list.add((Office) estate);
        model.addAttribute("allOffices", list);

        return "offices_page";
    }

    @RequestMapping(value = {"/apartmentsByApartmentComplex"}, method = RequestMethod.GET)
    public String showGetApartmentsByApartmentComplexView(Model model){
        GetApartmentsByApartmentComplexForm getApartmentsByApartmentComplex = new GetApartmentsByApartmentComplexForm();
        model.addAttribute("getApartmentsByApartmentComplex",getApartmentsByApartmentComplex);

        return "getApartmentsByApartmentComplexPage";
    }

    @RequestMapping(value = {"/apartmentsByApartmentComplex"}, method = RequestMethod.POST)
    public String getApartmentsByApartmentComplex(Model model, GetApartmentsByApartmentComplexForm getApartmentsByApartmentComplexForm){
        MyListImpl mylist = dao.getAps_in_Apscomplex_sortedfloor(getApartmentsByApartmentComplexForm.getName_of_AC()) ;
        List<Apartment> list = new ArrayList<>();
        for(Object estate: mylist)list.add((Apartment) estate);
        model.addAttribute("allApartments", list);

        return "apartments_page";
    }

    @RequestMapping(value = {"/officesByBusinessCenter"}, method = RequestMethod.GET)
    public String showGetOfficesByBusinessCenterView(Model model){
        GetOfficesByBusinessCenterForm getOfficesByBusinessCenterForm = new GetOfficesByBusinessCenterForm();
        model.addAttribute("getOfficesByBusinessCenterForm",getOfficesByBusinessCenterForm);

        return "getOfficesByBusinessCenterPage";
    }

    @RequestMapping(value = {"/officesByBusinessCenter"}, method = RequestMethod.POST)
    public String getOfficesByBusinessCenter(Model model, GetOfficesByBusinessCenterForm getOfficesByBusinessCenterForm){
        MyListImpl mylist = dao.getOffices_in_businesscenter_sortedcapacity(getOfficesByBusinessCenterForm.getName_of_BC());
        List<Office> list = new ArrayList<>();
        for(Object estate: mylist)list.add((Office) estate);
        model.addAttribute("allOffices", list);

        return "offices_page";
    }

    @RequestMapping(value = { "/addApartment" }, method = RequestMethod.GET)
    public String showAddApartmentView(Model model) {
        AddApartmentForm addApartmentForm = new AddApartmentForm();
        model.addAttribute("addApartmentForm", addApartmentForm);

        return "addApartmentPage";
    }

    @RequestMapping(value = { "/addApartment" }, method = RequestMethod.POST)
    public String addApartment(AddApartmentForm addApartmentForm) {
        dao.insertApartment(addApartmentForm.getName(),addApartmentForm.getArea(),addApartmentForm.getDate_of_build(),
        addApartmentForm.getPurchase_price(),addApartmentForm.getRent_price(),addApartmentForm.getRooms(),
                addApartmentForm.getIdComplex(),addApartmentForm.getFloor(),addApartmentForm.getSeparate_bathroom(),
                addApartmentForm.getBalcony_area());

        return "redirect:/apartments";
    }

    @RequestMapping(value = { "/addOffice" }, method = RequestMethod.GET)
    public String showAddOfficeView(Model model) {
        AddOfficeForm addOfficeForm = new AddOfficeForm();
        model.addAttribute("addOfficeForm", addOfficeForm);

        return "addOfficePage";
    }

    @RequestMapping(value = { "/addOffice" }, method = RequestMethod.POST)
    public String addOffice(AddOfficeForm addOfficeForm) {
        dao.insertOffice(addOfficeForm.getName(),addOfficeForm.getArea(),addOfficeForm.getDate_of_build(),addOfficeForm.getCapacity(),
                addOfficeForm.getEmergency_exits(),addOfficeForm.isParking(),addOfficeForm.getIdCenter(),addOfficeForm.getConference_halls(),
                addOfficeForm.getNegotiation_rooms(),addOfficeForm.isBiometric_security());

        return "redirect:/offices";
    }

    @RequestMapping(value = { "/updateApartment" }, method = RequestMethod.GET)
    public String showUpdateApartmentView(Model model) {
        UpdateApartmentForm updateApartmentForm = new UpdateApartmentForm();
        model.addAttribute("updateApartmentForm", updateApartmentForm);

        return "updateApartmentPage";
    }

    @RequestMapping(value = { "/updateApartment" }, method = RequestMethod.POST)
    public String updateApartment(Model model, UpdateApartmentForm updateApartmentForm) {
        dao.updateApartment(updateApartmentForm.getName(),updateApartmentForm.getArea(),updateApartmentForm.getPurchase_price(),
                updateApartmentForm.getRent_price(),updateApartmentForm.getRooms(),updateApartmentForm.isSeparate_bathroom(),
                updateApartmentForm.getBalcony_area());

        return "redirect:/apartments";
    }

    @RequestMapping (value ={"/updateOffice"},method = RequestMethod.GET)
    public String showUpdateOfficeView(Model model){
        UpdateOfficeForm updateOfficeForm = new UpdateOfficeForm();
        model.addAttribute("updateOfficeForm",updateOfficeForm);

        return "updateOfficePage";
    }

    @RequestMapping (value = {"/updateOffice"}, method = RequestMethod.POST)
    public String updateOffice(UpdateOfficeForm updateOfficeForm){
        dao.updateOffice(updateOfficeForm.getName(),updateOfficeForm.getArea(),updateOfficeForm.getCapacity(),
                updateOfficeForm.getEmergency_exits(),updateOfficeForm.isParking(),updateOfficeForm.getConference_halls(),
                updateOfficeForm.getNegotiation_rooms(),updateOfficeForm.isBiometric_security());

        return "redirect:/offices";
    }

    @RequestMapping (value = {"/deleteApartment"},method = RequestMethod.GET)
    public String ShowDeleteApartmentView (Model model){
        DeleteApartmentForm deleteApartmentForm = new DeleteApartmentForm();
        model.addAttribute("deleteApartmentForm",deleteApartmentForm);

        return "deleteApartmentPage";
    }

    @RequestMapping (value = {"/deleteApartment"},method = RequestMethod.POST)
    public String deleteApartment(DeleteApartmentForm deleteApartmentForm){
        dao.removeApartment(deleteApartmentForm.getApartmentName());

        return "redirect:/apartments";
    }

    @RequestMapping (value = {"/deleteOffice"},method = RequestMethod.GET)
    public String ShowDeleteOfficeView(Model model){
        DeleteOfficeForm deleteOfficeForm = new DeleteOfficeForm();
        model.addAttribute("deleteOfficeForm",deleteOfficeForm);

        return "deleteOfficePage";
    }

    @RequestMapping (value = {"/deleteOffice"}, method = RequestMethod.POST)
    public String deleteOffice(DeleteOfficeForm deleteOfficeForm){
        dao.removeOffice(deleteOfficeForm.getOfficeName());

        return "redirect:/offices";
    }

    @RequestMapping (value = {"/apartmentsByDistrict"},method = RequestMethod.GET)
    public String ShowApartmentsByDistrict (Model model){
        GetEstateByDistrictForm getEstateByDistrictForm = new GetEstateByDistrictForm();
        model.addAttribute("getEstateByDistrictForm",getEstateByDistrictForm);

        return "getApartmentsByDistrictPage";
    }

    @RequestMapping (value = {"/apartmentsByDistrict"},method = RequestMethod.POST)
    public String getApartmentsByDistrict (Model model, GetEstateByDistrictForm getEstateByDistrictForm){
        MyListImpl myList = dao.getApartments_in_district(getEstateByDistrictForm.getDistrict_name());
        List<Apartment> list= new ArrayList<>();
        for(Object estate:myList)list.add((Apartment)estate);
        model.addAttribute("allApartments",list);

        return "apartments_page";
    }

    @RequestMapping (value = {"/officesByDistrict"},method = RequestMethod.GET)
    public String ShowOfficesByDistrict (Model model){
        GetEstateByDistrictForm getEstateByDistrictForm = new GetEstateByDistrictForm();
        model.addAttribute("getEstateByDistrictForm",getEstateByDistrictForm);

        return "getOfficesByDistrictPage";
    }

    @RequestMapping (value = {"/officesByDistrict"},method = RequestMethod.POST)
    public String getOfficesByDistrict (Model model, GetEstateByDistrictForm getEstateByDistrictForm){
        MyListImpl myList = dao.getOffices_in_district(getEstateByDistrictForm.getDistrict_name());
        List<Office> list= new ArrayList<>();
        for(Object estate:myList)list.add((Office)estate);
        model.addAttribute("allOffices",list);

        return "offices_page";
    }
}
