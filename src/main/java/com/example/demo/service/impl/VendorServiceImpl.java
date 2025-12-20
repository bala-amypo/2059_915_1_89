public class VendorServiceImpl {
    private final VendorRepository vendorRepository;
    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }
    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }
}
