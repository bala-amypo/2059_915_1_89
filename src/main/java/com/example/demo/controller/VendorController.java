@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    private final VendorServiceImpl vendorService;

    public VendorController(VendorServiceImpl vendorService) {
        this.vendorService = vendorService;
    }

    // ✅ GET all vendors
    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    // ✅ Health check
    @GetMapping("/test")
    public String testVendorApi() {
        return "Vendor API is running successfully";
    }

    // ❌ POST (kept for completeness, blocked on amypo.ai)
    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);
    }

    // ✅ DEMO endpoint to simulate POST
    @GetMapping("/post-test")
    public Vendor createVendorUsingGet() {
        Vendor vendor = new Vendor("Amazon");
        return vendorService.createVendor(vendor);
    }
}
