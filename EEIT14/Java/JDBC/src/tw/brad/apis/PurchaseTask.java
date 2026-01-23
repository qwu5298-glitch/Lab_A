package tw.brad.apis;

public class PurchaseTask implements Task{
	private static final int PRODUCT_ID =1;
	final int qty;
	
	public PurchaseTask(int qty) {
		this.qty = qty;
	}
	
	@Override
	public void execute(StoreService service) throws Exception {
		try {
			service.purchase(PRODUCT_ID, qty);
		}catch(NotEnoughException e) {
			System.out.println("不足:" + qty);
		}
	}

	@Override
	public String label() {
		return "OUT :" + qty;
	}

}