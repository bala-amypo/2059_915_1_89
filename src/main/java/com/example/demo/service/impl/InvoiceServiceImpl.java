@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepo;
    private final UserRepository userRepo;
    private final VendorRepository vendorRepo;

    // ✅ USED BY TESTS
    public InvoiceServiceImpl(
            InvoiceRepository invoiceRepo,
            UserRepository userRepo,
            VendorRepository vendorRepo
    ) {
        this.invoiceRepo = invoiceRepo;
        this.userRepo = userRepo;
        this.vendorRepo = vendorRepo;
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepo.findAll();
    }

    @Override
    public Invoice uploadInvoice(Long userId, Long vendorId, Invoice invoice) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Vendor vendor = vendorRepo.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        invoice.setUploadedBy(user);
        invoice.setVendor(vendor);
        return invoiceRepo.save(invoice);
    }

    @Override
    public Invoice getInvoice(Long id) {
        return invoiceRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
    }

    @Override
    public List<Invoice> getInvoicesByUser(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return invoiceRepo.findByUploadedBy(user);
    }
}
