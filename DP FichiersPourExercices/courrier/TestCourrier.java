interface Contenu
{
	void encode(String texte);
	String toString();
}
class ContenuTexte implements Contenu
{
	protected String texte;
	public void encode(String texte)
	{
		this.texte = texte;
	}
	public String toString()
	{
		return (texte);
	}
}
class ContenuHtml implements Contenu
{
	protected String codeHtml;
	public void encode(String texte)
	{
		codeHtml = "<HTML>" + texte + "</HTML>";
	}
	public String toString()
	{
		return (codeHtml);
	}
}

public class Courrier <T extends Contenu>
{
	private T contenu;
	private String destinataire;
	
	//abstract protected Contenu nouveauContenu();	// Factory Method
	
	public Courrier(String nomClasse){
		Class <T> classe;
		try{
			classe = (Class<T>) Class.forName(nomClasse)
			try{
				contenu = classe.newInstance();
			}catch(InstantiationException | IllegalAccessException e){
				e.printStackTrace();
			}
		}
	}
	
	
	public void prepare(String destinataire, String texte)
	{
		this.destinataire = destinataire;
		contenu = nouveauContenu();
		contenu.encode(texte);
	}
	public String toString()
	{
		String st = "destinataire : " + destinataire + "\n";
		st += "contenu : " + contenu.toString();
		return st;
	}
}

class CourrierTexte extends Courrier
{
	protected Contenu nouveauContenu()
	{
		return new ContenuTexte();
	}
}
class CourrierHtml extends Courrier
{
	protected Contenu nouveauContenu()
	{
		return new ContenuHtml();
	}
}

public class TestCourrier
{

	public static void main(String[] args)
	{
		Courrier<ContenuHtml> moncourrier = new Courrier<ContenuHtml>("ContenuHtml");
		moncourrier.prepare("addresse@domaine", "texte1");
		
		
		
	}

}