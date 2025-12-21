@RestController
@RequestMapping("/api/invoices")
@CrossOrigin
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/upload")
    public Invoice uploadInvoice(
            @RequestParam Long userId,
            @RequestParam Long vendorId,
            @RequestBody Invoice invoice
    ) {
        return invoiceService.uploadInvoice(invoice, userId, vendorId);
    }
}
