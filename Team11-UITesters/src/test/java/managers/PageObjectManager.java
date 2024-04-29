package managers;

import org.openqa.selenium.WebDriver;

import pages.*;

public class PageObjectManager {
	
	private WebDriver driver;
	//private ArrayPage arrayPage;
	//private DataStructuresPage dataStructuresPage;
	private HomePage homePage;
	//private LandingPage landingPage;
	private SignInPage signinPage;
	private BatchPageValidation batchPageValidation;
	private AddBatchPage addBatchPage;
	private DeleteBatchPage deleteBatchPage;
	private EditBatchPage editBatchPage;
	//private RegisterPage registerPage;
	//private EditorPage editorPage;
	//private PracticePage practicePage;
	//private TreePage treePage;
	//private StackPage stackPage;
	//private LinkedListPage linkedListPage;
	
	public PageObjectManager(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	/*public ArrayPage getArrayPage()
	{
		return (arrayPage == null) ? arrayPage = new ArrayPage(driver) : arrayPage;
	}
	
	public DataStructuresPage getDataStructuresPage()
	{
		return (dataStructuresPage == null) ? dataStructuresPage = new DataStructuresPage(driver) : dataStructuresPage;
	}*/

	public HomePage getHomePage()
	{
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	
	/*public LandingPage getLandingPage()
	{
		return (landingPage == null) ? landingPage = new LandingPage(driver) : landingPage;
	}*/
	
	/*public RegisterPage getRegistrationPage()
	{
		return (registerPage == null) ? registerPage = new RegisterPage(driver) : registerPage;
	*/
	
	public SignInPage getSignInPage()
	{
		return (signinPage == null) ? signinPage = new SignInPage(driver) : signinPage;
	}
	
	public BatchPageValidation getBatchPageValidation()
	{
		return (batchPageValidation == null) ? batchPageValidation = new BatchPageValidation(driver) : batchPageValidation;
	}
	
	public AddBatchPage getAddBatchPage()
	{
		return (addBatchPage == null) ? addBatchPage = new AddBatchPage(driver) : addBatchPage;
	}
	
	public DeleteBatchPage getDeleteBatchPage()
	{
		return (deleteBatchPage == null) ? deleteBatchPage = new DeleteBatchPage(driver) : deleteBatchPage;
	}
	public EditBatchPage getEditBatchPage()
	{
		return (editBatchPage == null) ? editBatchPage = new EditBatchPage(driver) : editBatchPage;
	}
	/*public EditorPage getEditorPage()
	{
		return (editorPage == null) ? editorPage = new EditorPage(driver) : editorPage;
	}
	
	public PracticePage getPracticePage()
	{
		return (practicePage == null) ? practicePage = new PracticePage(driver) : practicePage;
	}
	
	public StackPage getStackPage()
	{
		return (stackPage == null) ? stackPage = new StackPage(driver) : stackPage;
	}
	
	public TreePage getTreePage()
	{
		return (treePage == null) ? treePage = new TreePage(driver) : treePage;
	}
	
	public LinkedListPage getLinkedListPage()
	{
		return (linkedListPage == null) ? linkedListPage = new LinkedListPage(driver) : linkedListPage;
	}*/
}
