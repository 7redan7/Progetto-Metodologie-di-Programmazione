package progetto.mp.net;

public interface NetVisitor {

	public void visitEndpoint(Endpoint endpoint);

	public void visitRouter(Router router);

}
